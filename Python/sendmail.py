"""
To send emails using enterprise SMTP server
"""

from email.message import EmailMessage
import smtplib
import logging

logging.basicConfig(level=logging.INFO,
                    format="%(asctime)s %(levelname)s - %(message)s")
# logger = logging.getLogger()

class SendMail:
    """
    SendMail(from_id = "from.ID@abc.com",
          to_id = "to.ID_1@Enterprise.com,to.id_2@Enterprise.com",
          subject = "text here",
          mail_body = "text here"
          cc = "optional"
          bcc = "optional"
          attach = "optional")
    Fails when To/Cc/Bcc is a non "Enterprise.com" ID
    """

    def __init__(self, from_id, to_id, subject, mail_body, cc=None, bcc=None, attach=None):
        msg = EmailMessage()

        # Set content
        if from_id is None:
            logging.error("Missing FROM ID")
            raise Exception("Missing FROM ID")
        else:
            msg['From'] = from_id
        if to_id is None:
            logging.error("Missing To ID")
            raise Exception("Missing To ID")
        else:
            to_list = to_id.split(",")
            msg['To'] = to_list
        if subject is None:
            logging.error("Missing mail Subject")
            raise Exception("Missing mail Subject")
        else:
            msg['Subject'] = subject
        if mail_body is None:
            logging.error("Missing content in the mail body")
            raise Exception("Missing content in the mail body")
        else:
            msg.set_content(mail_body)
        if cc is not None:
            cc_list = cc.split(",")
            msg['Cc'] = cc_list
        else:
            cc_list = []
        if bcc is not None:
            bcc_list = bcc.split(",")
            msg['Bcc'] = bcc_list
        else:
            bcc_list = []

        # Mail attachments
        m_type = 'application'
        s_type = 'octet-stream'
        if attach is not None:
            files = attach.split(",")
            for file in files:
                with open(file, 'rb') as atch:
                    f_data = atch.read()
                    f_name = atch.name
                msg.add_attachment(f_data, maintype=m_type, subtype=s_type, filename=f_name)        

        # Validate recipients
        mail_list = to_list + cc_list + bcc_list
        trim = [mail_id.strip() for mail_id in mail_list]
        recipients = [mail_id.lower() for mail_id in trim]
        for mail_id in recipients:
            if mail_id.endswith("Enterprise.com") is False:
                logging.error("You are trying to send mail to a Non Enterprise ID " + mail_id)
                raise Exception("You are trying to send mail to a Non Enterprise ID")

        # Send mail
        try:
            with smtplib.SMTP('SMTP.Enterprise.com') as smtp:
                smtp.send_message(msg)
            logging.info("Email sent")
        except:
            logging.error("Unknown error - Contact <insert details here>")
