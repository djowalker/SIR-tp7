<h1>tpJpa</h1>

<h2>Objectifs du TP</h2>

- Utilisation de Yeoman
- Utilisation d'AngularJs pour l'interface d'une application en JPA.

<h2>Sujet</h2>

Le but de ce TP est de construire à partir de vos compétences en AngularJS une interface Web pour votre application développée en Java côté serveur. 

<h2>Configurations</h2>

- Un IDE comme phpStorm
- Installer NodeJS
- Créer un Projet Yeoman

<h2>Installation</h2>

- Cloner le projet sur votre IDE préféré.
- Faire un update du projet grâce au pom.xml.


<h2>Lancement de l'application</h2>

<h3>Partie Server</h3>

- Lancer le serveur Tomcat 7 avec maven : ``` mvn tomcat7:run```
- Rendez vous sur ```http://localhost:8080/ ```

<h3>Partie Client</h3>

- Lancer le serveur grunt en ligne de commande : ``` grunt serve```
- Rendez vous sur ```http://localhost:9000/ ```

<h3>Database</h3>

- Vérifier les données : http://phpmyadmin2.istic.univ-rennes1.fr

<h2>API REST avec JPA(Jax-RS)</h2>
<table>
<tr>
<th>Method</th><th>URL</th><th>Action</th>
</tr>
<tr><td>GET</td>    <td>rest/user/getPersons</td><td>ajoute une personne</td></tr>
<tr><td>POST</td>   <td>rest/user/addPerson</td><td>affiche les personnes</td></tr>

</table>

<h2>Resultat</h2>

Ce TP est fonctionnel.

On peut ajouter une personne puis afficher toutes les personnes.
