output "api_proposal_url" {
  description = "API proposal URL"
  value = "https://${module.s3.api_proposal_domain_name}/proposal-api/index.html"
}
