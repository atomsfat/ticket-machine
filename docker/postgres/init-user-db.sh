#!/bin/bash
set -e
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
  CREATE USER dev_user PASSWORD 'D3V_P4ss&';
  CREATE DATABASE dev_data OWNER dev_user;
  GRANT ALL PRIVILEGES ON DATABASE dev_data TO dev_user;
EOSQL
