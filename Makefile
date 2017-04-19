


DROPBOX_TARGET_DIR=/Users/lauhub/DropBox/partagePublic/Enseignement/JAVA-AP/

all: DecouvrirJava.pdf DecouvrirJava.html dropbox

$(DROPBOX_TARGET_DIR)/DecouvrirJava.zip: DecouvrirJava.zip
	cp $< $@
$(DROPBOX_TARGET_DIR)/DecouvrirJava.pdf: DecouvrirJava.pdf
	cp $< $@


%.html: %.md
	pandoc -s -f markdown -t html $< -o $@

%.tex: %.md
	pandoc -s -f markdown -t latex $< -o $@

%.pdf: %.tex
	tpdf $< rebuild


DecouvrirJava.zip: DecouvrirJava.pdf DecouvrirJava.html
	zip DecouvrirJava.zip DecouvrirJava.html DecouvrirJava.pdf images/*

dropbox: $(DROPBOX_TARGET_DIR)/DecouvrirJava.zip $(DROPBOX_TARGET_DIR)/DecouvrirJava.pdf
