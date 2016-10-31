# Containerize a simple load balancer
FROM armhf/haproxy:1.6

# stats
EXPOSE 8888

COPY haproxy.cfg /usr/local/etc/haproxy/haproxy.cfg
