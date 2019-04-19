# API de gestion des collègues
Cette application, hébergée sur Heroku, permet de stocker les données de collègues dans une base de données et de les rechercher.


## Recherche d'un collègue par son nom
On récupère le matricule du collègue recherché grâce à une URL du type suivant: https://nicolas-collegues-api.herokuapp.com/collegues?nom=XXX (XXX étant le nom à rechercher)

Exemple: <a href="https://nicolas-collegues-api.herokuapp.com/collegues?nom=Marty">https://nicolas-collegues-api.herokuapp.com/collegues?nom=Marty</a>


## Recherche d'un collègue par son matricule
On récupère les données du collègue recherché à partir de son matricule grâce à une URL du type suivant: https://nicolas-collegues-api.herokuapp.com/XXX (XXX étant le matricule à rechercher)




## Avec une application du type Postman, vous pouvez tester les requêtes HTTP suivantes:

### Ajout d'un nouveau collègue via une requête de type POST

Utilisation de l'url suivante: href="https://nicolas-collegues-api.herokuapp.com/collegues

Dans le body de la requête un objet JSON doit être envoyé avec le format suivant:
```

{
    "nom": "Mermoz",
    "prenoms": "Jules",
    "dateDeNaissance": "1950-10-15",
    "photoUrl": "http://image.jpg",
    "email": "mail@mail.com"
}

```

### Modification d'un email et/ou de l'url de la photo du collègue via une requête de type PATCH

Utilisation de l'url suivante: href="https://nicolas-collegues-api.herokuapp.com/collegues/XXX (XXX étant le matricule du collègue à modifier)

Dans le body de la requête un objet JSON doit être envoyé avec le format suivant:
```

{
    "email": "mail@mail.com",
    "photoUrl": "http://image.jpg"
}


```
Vous pouvez ne modifier qu'un seul de ces éléments ou les deux mais dans ce dernier cas,
veillez à repecter l'ordre présenté ci-desus.

