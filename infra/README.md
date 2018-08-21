- Make a aws account
- Install aws-cli and configure it.

```bash
  aws configure
```

- Install terraform

```bash
  brew install terraform
```

- Verify that aws-cli is ok
```bash
aws sts get-caller-identity
```
- Init terraform
```bash
terraform init -backend-config='bucket=CHANGE_THIS' -backend-config='region=CHOOSE_SOME'
```
- Deploy all resources on aws
```bash
terraform apply -var 's3_prefix=REPLACE_FOR_YOUR_OWN_PREFIX"
```