#!/usr/bin/env bash
set -e
#ensamble swagger
node api-doc/build/prepare.js
#populate venue
cat api-doc/dist/ticketmachine-bundle.yaml | fake-schema -y -r Venue -l es_MX | http POST :8080/venue
