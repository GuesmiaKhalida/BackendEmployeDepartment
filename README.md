# backend-Example
Application a base de microservice
Ce projet consiste en une application basée sur une architecture de microservices. L'application est relativement simple : chaque employé travaille dans un seul département.

Nous avons commencé par créer un microservice pour la gestion des départements, appelé Department Microservice. Un département est représenté par les attributs suivants : id et name. Ce microservice fournit une API CRUD complète pour gérer les départements.

Ensuite, nous avons développé un Employee Microservice pour gérer les employés. Un employé est défini par les attributs suivants : id, nom, prénom, email, et id du département. Ce microservice offre les fonctionnalités suivantes via son API : ajout, suppression, modification, et récupération des employés. De plus, il communique avec le Department Microservice pour récupérer le nom du département où travaille chaque employé, illustrant ainsi la communication entre microservices.

Pour compléter l'application, nous avons intégré un Gateway Microservice pour centraliser les appels API et un Registry Microservice pour gérer la découverte des services.
