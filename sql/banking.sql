/*
 Navicat Premium Data Transfer

 Source Server         : dbclass
 Source Server Type    : PostgreSQL
 Source Server Version : 120000
 Source Host           : localhost:5433
 Source Catalog        : banking
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120000
 File Encoding         : 65001

 Date: 19/03/2020 14:45:56
*/


-- ----------------------------
-- Sequence structure for Account_number_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "Account_number_seq";
CREATE SEQUENCE "Account_number_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for Movement_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "Movement_id_seq";
CREATE SEQUENCE "Movement_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for Account
-- ----------------------------
DROP TABLE IF EXISTS "Account";
CREATE TABLE "Account" (
  "number" int4 NOT NULL DEFAULT nextval('"Account_number_seq"'::regclass),
  "balance" numeric(255) NOT NULL DEFAULT 0,
  "customer_cpr" text COLLATE "pg_catalog"."default" NOT NULL,
  "bank_cvr" text COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for Bank
-- ----------------------------
DROP TABLE IF EXISTS "Bank";
CREATE TABLE "Bank" (
  "cvr" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for Customer
-- ----------------------------
DROP TABLE IF EXISTS "Customer";
CREATE TABLE "Customer" (
  "cpr" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "bank_cvr" text COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for Movement
-- ----------------------------
DROP TABLE IF EXISTS "Movement";
CREATE TABLE "Movement" (
  "id" int4 NOT NULL DEFAULT nextval('"Movement_id_seq"'::regclass),
  "date" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "amount" numeric(255) NOT NULL,
  "withdrawing_account_number" int4 NOT NULL,
  "depositing_account_number" int4 NOT NULL
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "Account_number_seq"
OWNED BY "Account"."number";
SELECT setval('"Account_number_seq"', 2, false);
ALTER SEQUENCE "Movement_id_seq"
OWNED BY "Movement"."id";
SELECT setval('"Movement_id_seq"', 2, false);

-- ----------------------------
-- Primary Key structure for table Account
-- ----------------------------
ALTER TABLE "Account" ADD CONSTRAINT "number_unq" PRIMARY KEY ("number");

-- ----------------------------
-- Primary Key structure for table Bank
-- ----------------------------
ALTER TABLE "Bank" ADD CONSTRAINT "cvr_unq" PRIMARY KEY ("cvr");

-- ----------------------------
-- Primary Key structure for table Customer
-- ----------------------------
ALTER TABLE "Customer" ADD CONSTRAINT "cpr_unq" PRIMARY KEY ("cpr");

-- ----------------------------
-- Primary Key structure for table Movement
-- ----------------------------
ALTER TABLE "Movement" ADD CONSTRAINT "Movement_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table Account
-- ----------------------------
ALTER TABLE "Account" ADD CONSTRAINT "account_bank_cvr_fk" FOREIGN KEY ("bank_cvr") REFERENCES "Bank" ("cvr") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "Account" ADD CONSTRAINT "account_customer_cpr_fk" FOREIGN KEY ("customer_cpr") REFERENCES "Customer" ("cpr") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table Customer
-- ----------------------------
ALTER TABLE "Customer" ADD CONSTRAINT "customer_bank_cvr_fk" FOREIGN KEY ("bank_cvr") REFERENCES "Bank" ("cvr") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table Movement
-- ----------------------------
ALTER TABLE "Movement" ADD CONSTRAINT "movement_account_depositing_number_fk" FOREIGN KEY ("depositing_account_number") REFERENCES "Account" ("number") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "Movement" ADD CONSTRAINT "movement_account_withdrawing_number_fk" FOREIGN KEY ("withdrawing_account_number") REFERENCES "Account" ("number") ON DELETE NO ACTION ON UPDATE NO ACTION;
