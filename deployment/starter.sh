#!/usr/bin/env bash
set -x
./entrypoint.sh & ../docker-entrypoint.sh postgres
