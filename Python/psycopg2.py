from psycopg2 import pool

# Create a connection to a PostgreSQL DB
connectionPool = pool.SimpleConnectionPool(1, # Min connections in pool
                                           10, # Max connections in pool
                                           database="learning",
                                           user="postgres",
                                           password="",
                                           host="localhost")

# Write to DB
with connectionPool.getconn() as connection:
    with connection.cursor() as cursor:
        cursor.execute("insert into items values('Curtain', 9, 120)")

# Read from DB        
with connectionPool.getconn() as connection:
    with connection.cursor() as cursor:
        cursor.execute("select * from items")
        get = cursor.fetchall()
        print(get)        
# For more options, check dir(cursor)
