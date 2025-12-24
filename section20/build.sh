#!/bin/bash
set -e

services=(accounts cards configserver eurekaserver gatewayserver loans message)

for s in "${services[@]}"; do
  echo "Building $s"
  (cd "$s" && mvn compile jib:dockerBuild)
done

for s in "${services[@]}"; do
  echo "Pushing $s"
  docker push "mordiniaa/$s:s20"
done