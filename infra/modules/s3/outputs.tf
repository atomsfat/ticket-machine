output "api_proposal_arn" {
  value = "${aws_s3_bucket.api_proposal.arn}"
}
output "api_proposal_bucket" {
  value = "${aws_s3_bucket.api_proposal.bucket}"
}
output "api_proposal_domain_name" {
  value = "${aws_s3_bucket.api_proposal.bucket_regional_domain_name}"
}