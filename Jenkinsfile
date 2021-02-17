pipeline {

  agent {
    label 'Slave_Induccion'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	 disableConcurrentBuilds()
  }

  tools {
    jdk 'JDK13_Centos'
    gradle 'Gradle6.0.1_Centos'
  }

  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM',
			branches: [[name: '*/master']],
			doGenerateSubmoduleConfigurations: false,
			extensions: [],
			gitTool: 'Default',
			submoduleCfg: [],
			userRemoteConfigs: [[
				credentialsId: 'Github_jmurilloariza',
				url:'https://github.com/jmurilloariza/parking-ceiba.git'
			]]
		])
      }
    }

    stage('Clean') {
      steps{
        echo "------------>Clean<------------"
	dir("microservicio") {
            sh 'gradle --b ./microservicio/build.gradle clean'
	}
      }
    }

    stage('Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
	dir("microservicio") {
            sh 'gradle --b ./microservicio/build.gradle clean'
            sh 'gradle --b ./microservicio/build.gradle jacocoTestReport'
	}
      }
    }

    stage('Static Code Analysis') {
      steps{
          echo '------------>Análisis de código estático<------------'

		withSonarQubeEnv('Sonar') {
                  sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
                }


       }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
	dir("microservicio") {
	    sh 'gradle --b ./microservicio/build.gradle build -x test'
	}

      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'jeferson.murillo@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
  }
}