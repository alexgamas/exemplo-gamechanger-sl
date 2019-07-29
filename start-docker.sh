##################
##    DOCKER    ##
##################

docker network rm gamechanger
docker rm -f database
docker rm -f dbadmin

docker network create --driver bridge gamechanger

docker run --name database \
    -e POSTGRES_DB=gamechanger \
    -e POSTGRES_USER=gamechangerproject \
    -e POSTGRES_PASSWORD=gamechangerproject \
    --net=gamechanger -p 5432:5432 -d postgres:9

docker run -p 8000:80 -d --name dbadmin \
    -e "PGADMIN_DEFAULT_EMAIL=admin" \
    -e "PGADMIN_DEFAULT_PASSWORD=1234" \
    --net=gamechanger dpage/pgadmin4

