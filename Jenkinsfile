pipeline {
    agent any
     environment {
            DOCKERHUB_CREDENTIALS_ID = 'docker-login'
            DOCKERHUB_REPO = 'hetahar/shoppingcart'
            DOCKER_IMAGE_TAG = 'latest_v1'
        }
     tools {
            jdk 'Java 21'
            maven 'maven_3.9.9'
     }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Hetahar/shoppingcart-test.git'

            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

         stage('Build Docker Image') {
                    steps {
                        script {
                            docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                        }
                    }
                }
                stage('Push Docker Image to Docker Hub') {
                    steps {
                        // Push Docker image to Docker Hub
                        script {
                            docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                                docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                            }
                        }
                    }
                }
    }
}