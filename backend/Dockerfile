FROM python:3.12-slim
WORKDIR /srv/am2
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt
COPY app ./app
RUN mkdir -p /srv/am2/data
ENV AM2_DB_PATH=/srv/am2/data/am2.db
EXPOSE 8000
CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]
