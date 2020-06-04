provider "aws" {
  region = "${var.aws_region}"
}
//terraform {
//  backend "s3" {
//    encrypt = true
//    bucket = "atoms-tf-state-storage"
//    region = "us-west-2"
//    dynamodb_table = "terraform-state-lock"
//    key = "terraform.tfstate"
//  }
//}
module "s3" {
  source = "./modules/s3"
  prefix = "${var.s3_prefix}"
}
