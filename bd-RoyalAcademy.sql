drop schema if exists royalAcademy;

create schema if not exists royalAcademy;

use royalAcademy;

drop table if exists Usuario;

create table Usuario(
	idUsuario int primary key auto_increment,
	nombreYApellido varchar(45),
	dni int,
	nombreUsuario varchar(45),
	contrasenia varchar(45),
	tipoUsuario int,
	eliminado bit(1) default b'0',
	foreign key (tipoUsuario) references TipoUsuario(idTipoUsuario)    
    );

drop table if exists TipoUsuario;
create table TipoUsuario(
	idTipoUsuario int primary key auto_increment,
    tipoUsuario varchar(45)
);

insert into TipoUsuario values(0, 'administrador');
insert into TipoUsuario values(0, 'docente');
insert into TipoUsuario values(0, 'alumno');

insert into Usuario values (0, 'Martinez Carlos', 36161871, 'carlossmarts', 'pass', 1, 0);

select * from Usuario;

SELECT u.idUsuario,u.nombreYApellido, u.dni, u.nombreUsuario, u.contrasenia, tu.idTipoUsuario, tu.tipoUsuario
				FROM Usuario u inner join TipoUsuario tu 
                on u.tipoUsuario = tu.idTipoUsuario
				where u.idUsuario=1;