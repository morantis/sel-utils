module all;

import std.conv : to;
import std.file : dirEntries, SpanMode, read, isFile, _write = write;
import std.json;
import std.path : dirSeparator;
import std.string;
import std.typecons : Tuple, tuple;
import std.xml;

static import d;
static import java;
static import js;

static import doc;
static import json;

alias File(T) = Tuple!(string, "software", size_t, "protocol", T[], "data");

alias Attribute = Tuple!(string, "id", string, "name", float, "min", float, "max", float, "def");

alias Attributes = File!Attribute;

void main(string[] args) {

	// attributes
	Attributes[string] attributes;
	foreach(string file ; dirEntries("../xml/attributes", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".xml")) {
			Attributes curr;
			foreach(element ; new Document(cast(string)read(file)).elements) {
				switch(element.tag.name) {
					case "software":
						curr.software = element.text.strip;
						break;
					case "protocol":
						curr.protocol = element.text.strip.to!size_t;
						break;
					case "attribute":
						with(element.tag) curr.data ~= Attribute(attr["id"], attr["name"], attr["min"].to!float, attr["max"].to!float, attr["default"].to!float);
						break;
					default:
						break;
				}
			}
			attributes[file.name!"xml"] = curr;
		}
	}

	// constants
	JSONValue[string] constants;
	foreach(string file ; dirEntries("../json/constants", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".json")) {
			constants[file.name!"json"] = parseJSON(cast(string)read(file)).object["constants"];
		}
	}

	// creative
	JSONValue[string] creative;
	foreach(string file ; dirEntries("../json/creative", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".json")) {
			creative[file.name!"json"] = parseJSON(cast(string)read(file)).object["items"];
		}
	}

	// metadata
	JSONValue[string] metadata;
	foreach(string file ; dirEntries("../json/metadata", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".json")) {
			metadata[file.name!"json"] = parseJSON(cast(string)read(file)).object;
		}
	}

	// particles
	JSONValue[string] particles;

	// protocol
	JSONValue[string] protocol;
	foreach(string file ; dirEntries("../json/protocol", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".json")) {
			protocol[file.name!"json"] = parseJSON(cast(string)read(file)).object;
		}
	}

	// sounds
	JSONValue[string] sounds;

	auto jsons = [
		"constants": JSONValue(constants),
		"metadata": JSONValue(metadata),
		"particles": JSONValue(particles),
		"protocol": JSONValue(protocol),
		"sounds": JSONValue(sounds),
	];

	d.d(attributes, jsons);
	java.java(attributes, jsons);
	js.js(attributes, jsons);

	doc.doc();
	json.json(attributes);

}

@property string name(string ext)(string file) {
	return file[file.lastIndexOf(dirSeparator)+1..$-ext.length-1];
}

@property string toCamelCase(string str) {
	string ret = "";
	bool next_up = false;
	foreach(c ; str.toLower.dup) {
		if(c == '_') {
			next_up = true;
		} else if(next_up) {
			ret ~= toUpper(c);
			next_up = false;
		} else {
			ret ~= c;
		}
	}
	return ret;
}

@property string toPascalCase(string str) {
	string camel = toCamelCase(str);
	return camel.length > 0 ? toUpper(camel[0..1]) ~ camel[1..$] : "";
}

@property string toSnakeCase(string str) {
	string snaked;
	foreach(c ; str.dup) {
		if(c >= 'A' && c <= 'Z') snaked ~= '_';
		snaked ~= c;
	}
	return snaked.toLower;
}

void write(string file, string data) {
	_write(file, "// This file has been automatically generated by sel-utils\n// https://github.com/sel-project/sel-utils\n" ~ data.strip ~ "\n");
}
