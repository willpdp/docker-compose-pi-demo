#!/usr/bin/env ruby
require 'net/http'
require 'sinatra'
require 'json'

set :bind, '0.0.0.0'

get '/' do
  time_response = JSON.parse(get_json('time_source_service', '8080', '/'))
  colour_response = JSON.parse(get_json('funky_colour_service', '5000', '/'))
  style_response = JSON.parse(get_json('style_service', '8080', '/'))

  style = style_response['style'] || ''
  style = style
          .gsub('BACKGROUND', colour_response["background"] || "red")
          .gsub('FOREGROUND', colour_response["foreground"] || "white")

  erb :index, locals: { time_response: time_response,
                        colour_response: colour_response,
                        style_response: style_response,
                        style: style
                      }
end

def get_json(host, port, path)
  begin
    Net::HTTP.start(host, port) do |http|
      response = http.get(path)
      response.body
    end
  rescue => e
    "error contacting #{host}:#{port}#{path}: #{e}"
  end
end
