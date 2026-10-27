
# HYNEX — DevOps CI/CD & AI-Powered Automation

An end-to-end DevOps project combining CI/CD automation, containerization, Kubernetes deployment, security analysis, monitoring, and AI-assisted pipeline troubleshooting.

The goal is not only to automate software delivery, but also to make pipeline failures easier to investigate through intelligent, automated reporting.

## Architecture
<p align="center">
  <img src="Cloud-architecture%20(1).gif" alt="HYNEX DevOps Architecture" width="900">
</p>

The project connects the following components into a unified workflow:

**GitHub → Jenkins → Build & Test → Code Quality & Security Analysis → Docker → Container Registry → Kubernetes → Deployment Validation**

A separate automation workflow connects Jenkins to n8n and Groq AI to analyze pipeline failures and send troubleshooting reports by email.

## Technology Stack

| Category | Technologies |
|---|---|
| Source Control & CI/CD | Git, GitHub, Jenkins |
| Build & Testing | Maven |
| Code Quality | SonarQube |
| Security Analysis | OWASP Dependency-Check, Trivy |
| Containerization | Docker, Container Registry |
| Orchestration | Kubernetes |
| Deployment Validation | Rollout Checks, Smoke Tests |
| Monitoring | Prometheus, Grafana |
| Workflow Automation | n8n, Webhooks |
| AI Integration | Groq API, Llama 3.3 70B Versatile |
| Notifications | Automated Email Reports |

## Key Features

### 1. Automated CI/CD Pipeline
- Automates application builds and tests.
- Builds and publishes Docker images to a container registry.
- Deploys the application to Kubernetes.
- Verifies deployment status through rollout checks and smoke tests.

### 2. Code Quality & Security Analysis
- Uses SonarQube for code quality analysis.
- Uses OWASP Dependency-Check to identify known vulnerabilities in project dependencies.
- Uses Trivy for security scanning of supported targets.

### 3. Kubernetes Deployment
- Applies Kubernetes deployment configurations.
- Checks rollout status and validates application availability.
- Integrates deployment verification into the delivery workflow.

### 4. AI-Powered Failure Analysis
- Jenkins sends pipeline results to n8n through a webhook.
- The workflow processes failed build information and relevant console logs.
- Groq AI analyzes the available error context.
- An automated email report presents likely causes and suggested troubleshooting steps.

### 5. Monitoring
Prometheus and Grafana support metrics collection and visualization for monitoring the system.

## AI Troubleshooting Workflow

The automation workflow follows this process:

1. Jenkins completes a pipeline execution.
2. A webhook sends the build result to n8n.
3. The workflow checks the pipeline status.
4. For failures, relevant error information is collected and sent to the Groq API.
5. AI-generated analysis is formatted into an email report.
6. The report helps identify potential causes and next troubleshooting steps.

**The objective:** go beyond a simple "Build Failed" notification and provide more useful diagnostic information.

## Project Goals

- Practice end-to-end CI/CD automation.
- Integrate containerization and Kubernetes deployment.
- Incorporate code quality and security analysis.
- Explore monitoring and deployment validation.
- Automate failure reporting using workflow automation and large language models.

## Getting Started

### Prerequisites
- Git and GitHub
- Jenkins
- Java and Maven
- Docker and a container registry
- A Kubernetes environment
- SonarQube, OWASP Dependency-Check, and Trivy
- n8n and a Groq API key
- Email configuration for notifications

Prometheus and Grafana are needed to reproduce the monitoring component.

### Setup
1. Clone the repository.
2. Configure the required Jenkins tools, credentials, and pipeline settings.
3. Configure Docker and the container registry.
4. Prepare the Kubernetes cluster and deployment configuration.
5. Configure the n8n webhook, Groq API credentials, and email integration.
6. Run the pipeline and verify the deployment and notification workflow.

Exact configuration depends on your local environment and the settings defined in the project.

## Author

**Hadil Derbali**  
Software Engineer | DevOps, CI/CD & Automation

- GitHub: https://github.com/hadilderbali
- LinkedIn: https://www.linkedin.com/in/hadil-derbali-1a6b1a217/
- Portfolio: https://hadil-derbali-portfolio.netlify.app/
