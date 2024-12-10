pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Clonar o repositório
                git 'https://github.com/seu-repositorio.git'
            }
        }
        stage('Build and Test') {
            steps {
                // Limpar e executar os testes com Maven
                sh 'mvn clean test'
            }
        }
        stage('Generate Allure Report') {
            steps {
                // Gerar o relatório Allure
                sh 'allure generate allure-results --clean -o allure-report'
            }
        }
    }
    post {
        always {
            // Publicar o relatório no Jenkins
            allure([
                results: [[path: 'allure-results']]
            ])
        }
    }
}
