# Ticket-machine API Spec
This module handles the API spec using the yaml functions
`!!inc/dir`  and `!!inc/file`  in order to split the API
in several files.

* [Published API SPEC](https://atoms-one-api-proposal.s3.us-west-2.amazonaws.com/proposal-api/index.html)
## Development mode (webpack watcher)
  * Install dependencies
      * Node v12
      * npm install
  * DEV server
    
```bash
npm start
```

http://localhost:9000/

## Deploying on S3

```bash
./publish-api-doc.sh <bucket-name>
```


