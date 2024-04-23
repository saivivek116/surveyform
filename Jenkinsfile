// This file is used to create a pipeline for the CI/CD process
// author:
// Sai Vivek Vangaveti - G01413358
//  Venkata Sree Divya Kasturi - G01411963
//  Mary Ashwitha Gopu - G01408743
// Gangadhara Sai Kutukuppala - G01444780
pipeline{
	agent any
	environment {
		DOCKERHUB_PASS = "wfm4yjw1YUV8nvr!tmz"
	}
	stages{
		stage("Generating the Build for SWE645 student survey api"){
			steps{
				script{
					checkout scm
                    sh "mvn clean install -DskipTests"
					sh "echo ${DOCKERHUB_PASS} | docker login -u saivivek116 --password-stdin"
					sh 'docker build -t saivivek116/surveyapp .'
				}
			}
		}
		stage("Pushing image to docker"){
			steps{
				script{
					sh 'docker push saivivek116/surveyapp'
				}
			}
		}
		stage("Deploying to rancher"){
			steps{
				script{
				
					String kubeconfigPath = '/var/lib/jenkins/.kube/config'
            
					// Path to the manifest file
					String manifestPath = '/home/ubuntu/manifest.yaml'
            
					// Apply the manifest file to your Kubernetes cluster
					sh "kubectl --kubeconfig=${kubeconfigPath} apply -f ${manifestPath}"

					// Force a new rollout for the deployment
            		sh "kubectl --kubeconfig=/var/lib/jenkins/.kube/config rollout restart deployment/deployment"
            
					// Assuming your deployment's name is 'deployment', replace 'deployment' with your actual deployment name if different
					sh "kubectl --kubeconfig=${kubeconfigPath} rollout status deployment/deployment"
				}
			}
		}
	}
}