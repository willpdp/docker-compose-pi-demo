# Docker[-compose] demo, for Raspberry Pi [3]

Multi microservice Docker[-compose] demo.  A variety of languages are used.

NOTE: I wrote this to learn about Docker, it's a bit rough around the edges to say the least.

| service name         | language        | connects to                                              |
| ---                  | ---             | ---                                                      |
| time_display_service | ruby/sinatra    | funky_colour_service, style_service, time_source_service |
| funky_colour_service | python/flask    | time_display_service                                     |
| style_service        | java/dropwizard | time_display_service                                     |
| time_source_service  | golang          | time_display_service                                     |

## notes

Note that an intermediate container is build for each step in the Dockerfile, and reused if it has not
changed since the last build.  Consider that when writing Dockerfiles.

## installing Docker

[*cough* it's a curl|bash thing :(](https://www.raspberrypi.org/blog/docker-comes-to-raspberry-pi/)

To build an individual container: `docker build .` in one of the directories containing a Dockerfile

## installing docker-compose

[docs](https://docs.docker.com/compose/install/#/install-using-pip)

1. `virtualenv .venv`
2. `./.venv/bin/pip install docker-compose`
3. `./.venv/bin/docker-compose build`

## running

To run an individual container: `docker run .` in one of the directories containing a Dockerfile

To run all the containers: `./.venv/bin/docker-compose up` and [click](http://127.0.0.1:9999/)

The time_display_service contacts all the other services and displays the output, some of which
also affect the output displayed.  Particularly interesting are the hostnames - see the hostnames
where each is running.  Could be more interesting with more than one service running, but that needs
a working load balancer.

## future

* be nice to get this running with [dockercloud-haproxy](https://github.com/docker/dockercloud-haproxy)
  that automatically registers/de-registers new containers, but it doesn't have an arm build yet.
  see also: `./load_balancer/Dockerfile`

## licence

GPLv2, or later, unless source file(s) indicates otherwise

## links

[$DAYJOB Docker demo](https://github.com/willp-bl/team-challenges/tree/master/5_docker)
