#!/bin/sh
set -e

API_NAME=$1

if [ "$API_NAME" = "semive-backend" ]; then
    exec java -jar $API_NAME.jar "$@"
fi

exec "$@"