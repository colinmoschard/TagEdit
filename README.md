# TagEdit
TagEdit is a CLI application written in java made to quickly edit tags of your music files.
As of now, TagEdit only works with the .flac extension.

## Usage
Using the released jar file :
`java -jar tagedit.jar <arguments>`

### Example usage:

To view the application help, simply run it without arguments
or with the argument `--help`.

To simply view the tags of an audio file, use:

`java -jar tagedit.jar myaudiofile.flac`

without anymore arguments.

To change the title of an audio file, use:

`java -jar tagedit.jar myaudiofile.flac --title "My new title"`

For other tags simply use one (or more) of the arguments below

### Arguments
```sh
--album=<album>       album name
--artist=<artist>     artist name
--title=<title>       track title
--trackNo=<trackNo>   track number
--year=<year>         track year
```

The application will then ask you for a new filename, to copy the original to with the new tags,
if you don't specify a new filename, the application will overwrite your original file with the
new tags.

Enjoy !

## Building from source
Clone the project then:
### On IntelliJ IDEA Environment :
Configurations are included in the project files so you can build a jar file from there
### On bash:
run `TagEdit/mvnw -f TagEdit/pom.xml package clean`
### On windows:
run `TagEdit/mvnw.cmd -f TagEdit/pom.xml package clean`
