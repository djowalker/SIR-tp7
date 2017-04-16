<h1>tp7 - couche Angular sur le tp2 et 4 (jpa, servlet, jax-rs)

<h2> Description </h2>
Ce TP permet de mettre en oeuvre une communication entre des éléments en angularJS et en Java, jax-RS, Servlet.

Ainsi il est possible d'ajouter et de lister une maison avec les variables suivantes :
- l'addresse
- la ville
- le nombre de pièces
- la surface

<h2>Comment installer</h2>

- Cloner le projet.
- Faire un update du projet grâce au pom.xml.

<h2>Comment lancer l'application</h2>

<h3>Partie backend</h3>

- Lancer le serveur Tomcat 7 avec maven : ``` mvn tomcat7:run```
- Aller sur ```http://localhost:8080/ ```

<h3>Partie frontend</h3>

- Lancer le serveur grunt en ligne de commande : ``` grunt serve```
- Aller sur ```http://localhost:9000/ ```

<h3>Base de donnée</h3>

- Vérifier les données : http://phpmyadmin2.istic.univ-rennes1.fr

<h2>la partie REST</h2>

<table>
<tr>
<th>Method</th><th>URI</th><th>Action</th>
</tr>
<tr><td>GET</td>    <td>rest/home/listHome</td><td>ajoute une maison</td></tr>
<tr><td>POST</td>   <td>rest/home/addHomes</td><td>affiche la liste des maisons</td></tr>
</table>
