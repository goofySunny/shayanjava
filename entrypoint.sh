#!/bin/bash
/usr/local/bin/wait-for-it.sh db:5432 --timeout=60 --strict
exec catalina.sh run