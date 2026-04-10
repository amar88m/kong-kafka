# kong-kafka


kubectl apply -f kafka-namespace.yaml
kubectl get namespace kafka

kubectl apply -f zookeeper.yaml
kubectl apply -f kafka.yaml

kubectl get pods -n kafka
kubectl get svc -n kafka


kubectl describe deployment kafka -n kafka
kubectl describe pod -l app=kafka -n kafka