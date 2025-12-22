#!/bin/bash
set -e

dirs=(accounts cards configserver gatewayserver loans message)

cd bank-services

for s in "${dirs[@]}"; do
  echo "Helming $s"
  (cd "$s" && helm dependencies build)
done

cd ../environment

envs=(dev-env prod-env qa-env)

for s in "${envs[@]}"; do
  echo "Helming $s"
  (cd "$s" && helm dependencies build)
done