# Containerize a simple Python microservice
FROM armhf/python:3.6-slim

COPY requirements.txt .

EXPOSE 5000

RUN pip install -r requirements.txt

# do this later so fewer rebuilds of intermediate containers are
# required
COPY funky_colour_service.py .

CMD ./funky_colour_service.py
