# Nombre del archivo JAR
NAME = avaj-launcher.jar

# Directorios
SRC_DIR = ./src
BIN_DIR = ./bin

# Clase principal
MAIN_CLASS = Main

# Manifiesto
MANIFEST = ./MANIFEST.MF

# - - - - - - - - - - - - - - - - - #
# - - - - C O M P I L A C I Ó N - - #
# - - - - - - - - - - - - - - - - - #

all: $(NAME)

# Compilar y crear el JAR
$(NAME): 
	@echo "Compilando los archivos Java..."
	@javac -d $(BIN_DIR) $(SRC_DIR)/*.java $(SRC_DIR)/Classes/*.java
	@echo "Creando el archivo JAR..."
	@echo "Main-Class: $(MAIN_CLASS)" > $(MANIFEST)
	@jar cfm $(NAME) $(MANIFEST) -C $(BIN_DIR) .
	@echo "¡Compilación completada!"

# - - - - - - - - - - - - - - - - - #
# - - - - - - - T E S T - - - - - - #
# - - - - - - - - - - - - - - - - - #

test:
	@java -jar ./avaj-launcher.jar scenario.txt


# - - - - - - - - - - - - - - - - - #
# - - - - L I M P I E Z A - - - - - #
# - - - - - - - - - - - - - - - - - #

fclean:
	@echo "Limpiando archivos compilados y generados..."
	@rm -rf $(SRC_DIR)/*.class
	@rm -rf $(SRC_DIR)/Classes/*.class
	@rm -rf $(BIN_DIR)
	@rm -f $(NAME)
	@rm -f $(MANIFEST)
	@rm -rf simulation.txt
	@echo "¡Limpieza completada!"

re: fclean all
