pipeline {
    agent any

    tools {
        maven 'Maven-3'
    }

    environment {
        IMAGE_NAME = "customer-service"
        IMAGE_TAG  = "latest"
        CONTAINER_NAME = "customer-service"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:%IMAGE_TAG% .'
            }
        }

        stage('Stop Old Container (if exists)') {
            steps {
                bat '''
                docker ps -a -q -f name=%CONTAINER_NAME% > container.txt
                set /p CID=<container.txt
                if not "%CID%"=="" docker stop %CONTAINER_NAME%
                if not "%CID%"=="" docker rm %CONTAINER_NAME%
                del container.txt
                '''
            }
        }

        stage('Run New Container') {
            steps {
                bat 'docker run -d -p 8081:8080 --name %CONTAINER_NAME% %IMAGE_NAME%:%IMAGE_TAG%'
            }
        }
    }
}
