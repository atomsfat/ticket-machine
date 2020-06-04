resource "aws_s3_bucket" "api_proposal" {
  bucket = "${var.prefix}-api-proposal"
  acl = "public-read"
}
