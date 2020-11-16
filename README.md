# SpringRestPOC

## Setup locally

```bash
sudo install -d -o $USER -g $USER /usr/local/src/SpringRestPOC
git clone git@github.com:ypenn21/SpringRestPOC.git /usr/local/src/SpringRestPOC
cd /usr/local/src/SpringRestPOC
git checkout -b $USER-my-working-branch
```

## Run locally

to run locally:


mvn clean install 


mvn spring-boot:run

This requires java 8 or higher 

## Automate the install the SpringRestPOC application to OpenShift with Ansible

Install Ansible locally and dependencies for the application and deployment to OpenShift. 

```bash
sudo yum install -y python3 python3-pip
sudo pip3 install --upgrade pip
sudo pip3 install ansible psycopg2-binary openshift jmespath --use-feature=2020-resolver
```

### Setup ssh on your computer for ansible to connect

For ansible to run commands, it needs to be able to ssh and run commands as sudo. For that, make sure the sshd service is started and enabled after a reboot. Also test an ssh connection to your hostname to make sure the host is accepted.

```bash
systemctl status sshd
sudo systemctl start sshd
sudo systemctl enable sshd
systemctl status sshd
ssh localhost
exit
```

### Ansible inventory

Create an inventory for your localhost to deploy the application to OpenShift. 

```ini
[springrestpoc_openshift]
localhost
```

### Ansible vault

Create an ansible vault for your OpenShift.

As a team, create and edit an encrypted ansible vault with a password for the host secrets for your shared OpenShift inventory.

```
install -d /usr/local/src/SpringRestPOC/ansible/inventories/$USER-openshift/group_vars/springrestpoc_openshift/

echo "VAULT_ID: $USER-openshift
" | tee /usr/local/src/SpringRestPOC/ansible/inventories/$USER-openshift/group_vars/springrestpoc_openshift/main.yml

install -d /usr/local/src/SpringRestPOC/ansible/vaults/$USER-openshift
ansible-vault create /usr/local/src/SpringRestPOC/ansible/vaults/$USER-openshift/vault
ansible-vault edit /usr/local/src/SpringRestPOC/ansible/vaults/$USER-openshift/vault
```

The contents of the vault will contain the secrets needed to override any default values you want to change in the app defaults defined in: SpringRestPOC/ansible/roles/springrestpoc_openshift/defaults/main.yml

### Ansible deployment to OpenShift

Run the Ansible Playbook to deploy the application to OpenShift

```bash
(cd /usr/local/src/SpringRestPOC/ansible && ansible-playbook springrestpoc_openshift.yml -i inventories/$USER-openshift/hosts --vault-id @prompt)
```
