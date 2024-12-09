# Nombre del archivo JAR
NAME = ajav-launcher.jar

# Directorios
SRC_DIR = ./src
BIN_DIR = ./bin

# Clase principal
MAIN_CLASS = Simulator

# Manifiesto
MANIFEST = ./MANIFEST.MF

# - - - - - - - - - - - - - - - - - #
# - - - - C O M P I L A C I Ó N - - #
# - - - - - - - - - - - - - - - - - #

all: $(NAME)

# Compilar y crear el JAR
$(NAME): 
	@echo "Compilando los archivos Java..."
	@javac -d $(BIN_DIR) $(SRC_DIR)/*.java
	@echo "Creando el archivo JAR..."
	@echo "Main-Class: $(MAIN_CLASS)" > $(MANIFEST)
	@jar cfm $(NAME) $(MANIFEST) -C $(BIN_DIR) .
	@echo "¡Compilación completada!"

# - - - - - - - - - - - - - - - - - #
# - - - - L I M P I E Z A - - - - - #
# - - - - - - - - - - - - - - - - - #

fclean:
	@echo "Limpiando archivos compilados y generados..."
	@rm -rf $(SRC_DIR)/*.class
	@rm -rf $(BIN_DIR)
	@rm -f $(NAME)
	@rm -f $(MANIFEST)
	@echo "¡Limpieza completada!"

re: fclean all
