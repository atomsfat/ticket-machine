variable "s3_prefix" {
  description = "cname compatible prefix, each bucket is unique"
}
variable "aws_region" {
  default = "us-west-2"
}

variable "environment" {
  default = "stage"
}