package info.oais.infomodel.interfaces;


/**
 * The information that documents the history of the Content Data Object. This
 * information tells the origin or source of the Content Data Object, any changes
 * that may have taken place since it was originated, and who has had custody of
 * it since it was originated. The Archive is responsible for creating and
 * preserving Provenance Information from the point of Ingest; however, earlier
 * Provenance Information should be provided by the Producer. Provenance
 * Information adds to the evidence to support Authenticity.  [OAIS]
 * @author David
 * @version 1.0
 * @since 06-Sep-2021 15:59:46
 */
public interface ProvenanceInformation extends InformationObject  {

}