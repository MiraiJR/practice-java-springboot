#!/usr/bin/env bash
# wait-for-it.sh

set -e

services=("$@")
for service in "${services[@]}"; do
    if [ "$service" = "--" ]; then
        shift
        break
    fi
  host=$(echo "$service" | cut -d ':' -f 1)
  port=$(echo "$service" | cut -d ':' -f 2)

  until nc -z "$host" "$port"; do
    # >&2 echo "Service $host on port $port is unavailable - sleeping"
    sleep 1
  done
  >&2 echo "Service $host on port $port is up"
  shift
done

cmd="$@"

>&2 echo "All services are up - executing command"
exec $cmd
