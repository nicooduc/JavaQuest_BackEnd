# JavaQuest - Guide d'Installation du Jeu

## Prérequis

Assurez-vous d'avoir les éléments suivants installés sur votre machine :

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Angular CLI](https://angular.io/guide/setup-local)
- [PostgreSQL](https://www.postgresql.org/download/)

## Étapes d'Installation

1. **Télécharger le Jeu**

2. **Ouvrir le Backend dans IntelliJ.**

3. **Configurer la Connexion à la Base de Données**
   - Dans l'onglet "Database" en haut à droite de l'IDE, sélectionnez "JavaQuest".
   - Utilisateur : JavaQuest
   - Mot de passe : JavaQuest
   - Base de données : JavaQuest
   - URL : jdbc:postgresql://localhost:5432/JavaQuest
   - Port : 5432

4. **Exécuter les Scripts d'Initialisation de la Base de Données**
   - Dans la section "initdb", sélectionnez et exécutez les trois fichiers d'initialisation de la base de données.

5. **Démarrer le Backend**
   - Lancez "BackSkeletonApplication" pour démarrer le backend du jeu.

6. **Ouvrir le FrontEnd dans une Nouvelle Fenêtre de l'IDE**

7. **Démarrer le Frontend**
   - Exécutez le "Serveur Angular CLI" pour démarrer le frontend.

8. **Accéder au Jeu**
   - Ouvrez votre navigateur web et allez sur [http://localhost:4200](http://localhost:4200).

9. **Amusez-vous bien sur JavaQuest !**

## Auteurs

- Nicolas Duchene
- Marc-Andréa Dehais
