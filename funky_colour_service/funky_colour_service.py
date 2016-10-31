#!/usr/bin/env python
from flask import Flask
from flask import Response
from socket import gethostname
from sys import version_info

app = Flask(__name__)

@app.route("/")
def funky_colour():
    hostname = gethostname()
    foreground = "#00FF00"
    background = "#FF0000"
    json = '{{ "foreground": "{}", "background": "{}", "hostname": "{}", "runtime": "{}" }}'.format(foreground, background, hostname, "python-{}.{}".format(version_info[0], version_info[1]))
    return Response(json, mimetype='application/json')

if __name__ == "__main__":
    app.run(host="0.0.0.0")
    
