.PHONY: help clean

PROJECT_ROOT=${PWD}


help:
	@clear
	@echo "[CAUTION]  PLEASE MODIFY THIS FILE CONVENIENTLY BEFORE USING IT!! "
	@echo "Builds or deploys a docker image from artifact version <version>"
	@echo
	@echo "Usage: make VERSION=<version> [COMMAND]"
	@echo
	@echo "Commands:"
	@echo
	@echo "  - build          : Builds a local image for the given version (recommended)"
	@echo "  - deploy         : Builds, and deploys into registry, a docker image for the given version (recommended)"
	@echo "  - build-noclean  : The same as build but without deleting preexisting scripts (faster)"
	@echo "  - deploy-noclean : The same as deploy but without deleting preexisting scripts (faster)"
	@echo "  - clean          : Deletes all local resources needed for building and deploying the docker image"
	@echo "  - destroy        : Cleanes local resources, stops docker and removes it from local"
	@echo

build: clean build-noclean
deploy: clean deploy-noclean

distZip:
	@gradle -b ${PROJECT_ROOT}/build.gradle :distZip

build-noclean: distZip
	@cp ${PROJECT_ROOT}/build/distributions/my-software-${VERSION}-SNAPSHOT.zip ${PWD} 
	@docker build --tag my-software-image:${VERSION} --build-arg VERSION=${VERSION} ${PWD}

deploy-noclean: build-noclean
	@docker tag my-software-image:${VERSION} registry:5000/my-software-image:${VERSION}
	@docker push registry:5000/my-software-image:${VERSION}
	@docker tag my-software-image:${VERSION} registry:5000/:latest
	@docker push registry:5000/my-software-image:latest

clean:
	@gradle -b ${PROJECT_ROOT}/build.gradle :clean
	@rm -fr ${PWD}/my-software-${VERSION}-SNAPSHOT.zip 

