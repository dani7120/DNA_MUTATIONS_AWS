pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        echo 'Git clone'
      }
    }
    stage('Maven dependencies') {
      steps {
        sh 'mvn clean'
      }
    }
  }
}