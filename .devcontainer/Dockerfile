# syntax=docker/dockerfile:1.7-labs

ARG TAG="25-bookworm"

FROM mcr.microsoft.com/devcontainers/java:${TAG}

ARG USERNAME="vscode"

ARG DEPENDENCY_MANAGER=".m2"

RUN sudo mkdir "/home/${USERNAME}/${DEPENDENCY_MANAGER}" \
    && sudo chown -R $USERNAME:$USERNAME "/home/${USERNAME}/${DEPENDENCY_MANAGER}"

ARG JAVA_VERSION="25-amzn"

RUN bash -lc '. /usr/local/sdkman/bin/sdkman-init.sh && sdk install java $JAVA_VERSION && sdk use java $JAVA_VERSION'

RUN curl \
    --proto '=https' \
    --tlsv1.2 \
    -sSf https://raw.githubusercontent.com/nektos/act/master/install.sh \
    | sudo bash

VOLUME "/home/${USERNAME}/${DEPENDENCY_MANAGER}"
