#!/usr/bin/env bash
if [ "$1" = "" ]; then
    echo "Provide a bucket as argument"
    exit -1
fi
BUCKET_API="$1"
node_modules/.bin/webpack --config build/webpack.config.js
aws s3 cp dist "s3://${BUCKET_API}/proposal-api" --exclude\
  ".git/*" --exclude ".idea" --recursive --acl public-read
echo "https://$BUCKET_API.s3.amazonaws.com/proposal-api/index.html"