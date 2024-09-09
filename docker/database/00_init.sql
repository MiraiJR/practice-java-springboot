CREATE USER replicator WITH REPLICATION ENCRYPTED PASSWORD '1234';
SELECT pg_create_physical_replication_slot('replication_slot');