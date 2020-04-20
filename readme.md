# Assignment 2: Anderer Leute Code

## Entwicklungsumgebung
- Ubuntu 18.04 in Oracle Virtualbox
- Java 11 installiert
- Außerdem ant, build-essential, git Pakete installieren
- Eclipse 2020/03 installiert

## Ant Build anpassen
- Zuerst mussten wir die 'compile.source' und das 'compile.target' von Version 1.5 auf 11 anheben.
- Wir hatten das Phänomen, dass der Build, als wir noch nichts geändert haben, beim Download an verschiedenen Stellen abgebrochen ist. Daher haben wir den Mirror der bei 'base-apache.loc.1' hinterlegt war ausgetauscht.
- Zusätzlich musste bei 'base-maven.loc' das http des Links zu https geändert werden.
- Abschließend haben wir 'base.path' so angepasst, dass die Bibliotheken an einer von uns definierten Stelle liegen.

Alle Änderungen bezüglich des Ant Builds sind in der Datei [build.properties](/02_tomcat/apache-tomcat-6.0.53-src/build.properties) zu finden.

## Fehlschlagende Testfälle
- Hier hatten wir eigenartige Konstellationen. In einer Virtualbox VM sind mehr Tests fehlgeschlagen, als in einer anderen.
- Nach einigem rumprobieren haben wir in Virtualbox die Anzahl der Prozessoren verringert und dann sind manchmal alle Tests ohne Fehler durchgelaufen. Bei höherer Prozessorzahl sind teilweise mehr Tests fehlgeschlagen.
- Wir haben uns zur Löschung der Tests entschieden, welche am häufigsten fehlgeschlagen sind. Commit [3ff0d59](https://github.com/lsd-lecture/team-16/commit/3ff0d59771e08a68202da2e5d3822e9f151b42b7)

## Eclipse Einbindung (nach [Tomcat-Buildanleitung](https://tomcat.apache.org/tomcat-6.0-doc/building.html))
- Zuerst haben wir die Datei "eclipse.classpath" kopiert und zu ".classpath" umbenannt. "eclipse.project" wurde zu ".project" umbenannt.
- Anschließend haben wir in Eclipse unter "Window > Preferences > Java > Build PAth > Classpath Variables" folgende Variablen hinzugefügt.
  - ANT_HOME: /usr/share/ant/
  - TOMCAT_LIBS_BASE: Pfad zu den mit 'ant download' heruntergeladenen Bibliotheken. In unserem Fall: '/team-16/02_tomcat/tomcat-build-libs'
- Abschließend haben wir das Projekt über 'File > Import > General > Import existing project into Workspace' in Eclipse importiert. Dann wird die "org.apache.catalina.startup.Catalina" gestartet mit "start" als "program argument".
- Seltsam hier ist, dass bei der Testausführung über Eclipse andere Tests fehlschlagen als über Ant.