# Tic Tac Toe

## Description
Ce projet est une implémentation simple du jeu de Tic-Tac-Toe en utilisant Kotlin et Jetpack Compose pour l'interface utilisateur. Le jeu permet à deux joueurs de jouer en alternance sur une grille 3x3. Le premier joueur à aligner trois symboles identiques dans une ligne, une colonne ou une diagonale gagne la partie.

## Fonctionnalités
- Grille de jeu de 3x3 interactive.
- Alternance automatique des joueurs ("X" et "O").
- Détection de victoire : la partie affiche un message lorsque l'un des joueurs remporte la partie.

## Prérequis
- Android Studio : Assurez-vous que la dernière version d'Android Studio est installée.
- Kotlin : Ce projet est entièrement écrit en Kotlin.
- Jetpack Compose : Utilisé pour construire l'interface utilisateur.

## Installation
Clonez ce dépôt GitHub sur votre machine locale :
git clone https://github.com/[VotreNomUtilisateur]/TicTacToe.git
Ouvrez le projet dans Android Studio :
Sélectionnez File > Open... puis accédez au dossier du projet cloné.
Synchronisez le projet avec Gradle si nécessaire.

## Exécution
Connectez un appareil Android physique ou démarrez un émulateur Android depuis Android Studio.
Appuyez sur le bouton Run (ou utilisez le raccourci Shift + F10) pour compiler et exécuter l'application.
L'application devrait se lancer sur l'appareil ou l'émulateur connecté, affichant la grille du jeu de Tic-Tac-Toe.

## Comment jouer
Le jeu commence avec le joueur "X".
Chaque joueur clique sur une case vide pour placer son symbole ("X" ou "O").
Les joueurs alternent après chaque tour.
Le premier joueur à aligner trois symboles identiques (horizontalement, verticalement ou en diagonale) gagne la partie.
Un message s'affiche pour annoncer le gagnant.

## Structure du Code
MainActivity : Activité principale de l'application, contenant le composable TicTacToeGame qui gère l'affichage de la grille de jeu.
TicTacToeGame : Composable principal qui affiche la grille de jeu et gère la logique du Tic-Tac-Toe.
checkWinner : Fonction qui vérifie si un joueur a remporté la partie en alignant trois symboles identiques.