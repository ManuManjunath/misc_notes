import logging

LOG_FORMAT = "%(asctime)s %(levelname)s %(message)s"
logging.basicConfig(filename="LogFile.txt", level=logging.DEBUG, format=LOG_FORMAT, filemode='a')

logger = logging.getLogger()

logger.debug("Message one")
logger.info("Message two")
logger.warning("Message three")
logger.error("Message four")
logger.critical("Message five")

# Outputs this - 
# DEBUG 2019-01-02 12:28:14,916 Message one - Debug
# INFO 2019-01-02 12:28:14,916 Message two - Info
# WARNING 2019-01-02 12:28:14,918 Message two - Warning
# ERROR 2019-01-02 12:28:14,918 Message two - Error
# CRITICAL 2019-01-02 12:28:14,918 Message two - Critical
