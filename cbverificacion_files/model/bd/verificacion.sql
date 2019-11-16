
	create table administrador(
		usuario varchar(100) not null,
		contrasena varchar(200) not null,
		primary key (usuario)
	) ENGINE=MyISAM;

	create table alumno(
		no_control int not null,
		usuario varchar(100) not null,
		alumno varchar(200) not null,
		contrasena varchar(200) not null,
		telefono varchar(15) not null,
		constraint PKAlumno primary key (no_control)
	) ENGINE=INNODB;

	create table codigo(
		codigo char(6) not null,
		no_control int not null,
		constraint PKCodigo primary key (codigo),
		constraint FKAlumno foreign key (no_control) references alumno(no_control)
	) ENGINE=INNODB;

insert into administrador values("mac", "mac");
insert into administrador values("caps", "caps");

insert into alumno values(1234567890, 'himechan', 'Cesar Axel Perdomo Saucedo', 'mc', '4433639002');
insert into alumno values(0987654321, 'mac', 'Braulio Jose Baca Barbosa', 'mac', '4611833992');
insert into alumno values(1122334455, 'tron', 'Alejandro Arriaga Ruiz', 'tron', '1111111111');
insert into alumno values(6677889900, 'rocketmaster', 'Roberto Carlos Martinez Colmenares', 'robe', '4111160962');
insert into alumno values(1231231230, 'fany', 'Stephanie Landin Nunez', 'fany', '4111250443');
